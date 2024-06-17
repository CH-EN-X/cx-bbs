
const axios = require('axios');

async function loadArticleData(params) {
    try {
        const { maxBehotTime, minBehotTime, size, tag } = params;
        const response = await axios.post("http://localhost:51602/api/article/load", { maxBehotTime, minBehotTime, size, tag });

        // 根据需要处理其他逻辑
        return response.data;
    } catch (error) {
        throw new Error('无法获取数据');
    }
}

module.exports = { loadArticleData };
