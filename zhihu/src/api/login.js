const express = require('express');
const router = express.Router();

router.post('/login', (req, res) => {
  const { username, password } = req.body;

  // 在实际应用中，您应该检查用户名和密码是否有效
  if (username === 'admin' && password === 'password') {
    // 如果用户名和密码有效，返回成功消息
    res.json({ message: '登录成功！' });
  } else {
    // 如果用户名和密码无效，返回错误消息
    res.status(401).json({ message: '用户名或密码错误！' });
  }
});

module.exports = router;