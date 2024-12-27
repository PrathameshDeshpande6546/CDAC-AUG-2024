const mysql = require("mysql2");
const pool = mysql.createPool({     // string which is required to connect to database
  host: "localhost",
  user: "KD1-86639-Prathamesh",
  password: "Prathamesh123",
  database: "airbnb_db",
  port: 3306,
  connectionLimit: 10,
});
module.exports = { pool };
