const fs = require('fs');
const path = require('path');
const propReader = require('properties-reader');

const pluginsDir = path.join(__dirname, 'plugins', 'v126');
const outputFile = path.join(__dirname, 'docs', 'index.md');

function isValidPlugin(pluginPath) {
    try {
        const files = new Set(fs.readdirSync(pluginPath));
        return files.has('info.prop') && files.has('main.java') && files.has('readme.md');
    } catch {
        return false;
    }
}

function parseInfoProp(filePath) {
    try {
        const props = propReader(filePath);
        return {
            name: props.get('name'),
            author: props.get('author'),
            version: props.get('version'),
            updateTime: props.get('updateTime'),
        };
    } catch {
        return {
            name: '未知插件',
            author: '佚名',
            version: '1.0.0',
            updateTime: '19700101',
        };
    }
}

function getPluginInfo(pluginPath) {
    const rel = path.relative(__dirname, pluginPath).replace(/\\/g, '/');
    const props = parseInfoProp(path.join(pluginPath, 'info.prop'));
    return {
        title: `${props.name}@${props.author}`,
        details: `版本 ${props.version} | 更新于 ${props.updateTime}`,
        link: `https://github.com/HdShare/WAuxiliary_Plugin/tree/main/${rel}`,
        rawProps: props,
    };
}

function traversePlugins(pluginDir) {
    const authors = fs.readdirSync(pluginDir).filter(sub => fs.statSync(path.join(pluginDir, sub)).isDirectory());
    const plugins = authors.flatMap(authorName => {
        const authorPath = path.join(pluginDir, authorName);
        return fs.readdirSync(authorPath)
            .filter(sub => fs.statSync(path.join(authorPath, sub)).isDirectory())
            .map(pluginName => {
                const pluginPath = path.join(authorPath, pluginName);
                return isValidPlugin(pluginPath) ? getPluginInfo(pluginPath) : null;
            })
            .filter(Boolean);
    });
    return plugins.sort((a, b) => {
        const timeA = parseInt(a.rawProps.updateTime);
        const timeB = parseInt(b.rawProps.updateTime);
        return timeB - timeA;
    });
}

function generateMarkdown(plugins) {
    let md = `---\nlayout: home\n\nhero:\n  name: "WAuxiliary Plugin"\n  text: "WAuxiliary 插件"\n\nfeatures:\n`;
    plugins.forEach(plugin => {
        md += `  - title: ${plugin.title}\n    details: ${plugin.details}\n    link: ${plugin.link}\n\n`;
    });
    return md;
}

const plugins = traversePlugins(pluginsDir);
const markdown = generateMarkdown(plugins);
fs.writeFileSync(outputFile, markdown, 'utf8');
console.log('docs/index.md 已自动生成');
