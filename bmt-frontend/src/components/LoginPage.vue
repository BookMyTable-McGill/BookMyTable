<template>
  <div class="container">
    <h1>Login</h1>
    <hr />
    <h1>Welcome Back!</h1>
    <br /><br /><br />
    <label id="emailLogin" for="emailLogin"><b>Email</b></label
    ><br />
    <input type="text" placeholder="Enter Email" name="emailLogin" id="emailLogin" />

    <br /><label id="pswLogin" for="pswLogin"><b>Password</b></label
    ><br />
    <input type="password" placeholder="Enter Password" name="pswLogin" id="pswLogin" />

    <br /><button type="submit" class="loginbtn">Login</button>

    <div class="container createAccount">
      <p>
        Don't have an account? <router-link to="/">Create account</router-link>.
      </p>
    </div>
  </div>
</template>

<style>
* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
}
input[type="text"]:focus,
input[type="password"]:focus {
  background-color: #ddd;
  outline: none;
}
/* Half-width input fields */
input[name="emailLogin"],
input[name="pswLogin"] {
  width: 50%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  border-radius: 5px;
  background: #f1f1f1;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the login button */
.loginbtn {
  background-color: #4d9aff;
  color: black;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  width: 50%;
  opacity: 0.9;
}

.loginbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "create account" section */
.createAccount {
  background-color: #f1f1f1;
  text-align: center;
  border: none;
}

label[id="emailLogin"] {
  right: 250px;
  position: relative;
}

label[id="pswLogin"] {
  right: 230px;
  position: relative;
}
</style>