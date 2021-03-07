const express = require("express"); //express
const morgan = require("morgan"); // HTTP request logger middleware
const helmet = require("helmet"); // Help secure Express/Connect apps with various HTTP headers
const nodemailer = require('nodemailer');
require("dotenv").config({ path: __dirname + "/../.env" });

const port = process.env.PORT || 3001;
console.log(`
PORT = ${process.env.PORT},
`);
var transporter = nodemailer.createTransport({
  service: 'gmail',
  auth: {
    user: 'belgiumkempton@gmail.com',
    pass: 'belgiumcampus'
  }
});




const sendMail = (to, subject, text) => {
  var mailOptions = {
    from: 'belgiumkempton@gmail.com',
    to,
    subject,
    text
  };
  transporter.sendMail(mailOptions, function(error, info){
    if (error) {
      console.log(error);
    } else {
      console.log('Email sent: ' + info.response);
    }
  });
}

const app = express();

app.use(morgan("dev"));
app.use(helmet());
app.use(express.json());

app.get("/", (req, res, next) => {
  try {
    throw new Error("THIS IS JUST A TEST ERROR");
    res.json({
      success: "true",
      message: `Welcome to API`,
      data: {},
    });
  } catch (error) {
    next(error);
  }
});
app.post("/SendMail", (req, res, next) => {
  try {
    res.json({
      success: "true",
      message: "Mail sent",
      
    });
    sendMail(req.headers['to'], req.headers['subject'], req.headers['text']);
  } catch (error) {
    next(error);
  }
});

app.use(function (req, res, next) {
  res.status(404).send(`404 NOT FOUND, INVALID URL > ${req.originalUrl}`);
});

//Error
app.use((error, req, res, next) => {
  if (error.status) {
    res.status(error.status);
  } else {
    res.status(500);
  }
  const stack = process.env.NODE_ENV === "production" ? error.stack : "🌌";
  res.json({
    message: error.message,
    stack,
  });
});

app.listen(port, () => {
  console.log(`Listening on http://localhost:${port}`);
});