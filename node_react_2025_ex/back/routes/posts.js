const express = require('express');
const router = express.Router();

router.post('/', (req, res) => {
  res.send('페이징 출력');
});

module.exports = router;
