<script src="./javascript/restaurantInfo.js"> </script>
<template>
  <div class="container">
    <h1>Restaurant Info</h1>
    <hr />
    <br /><br /><br />
    Name : {{restaurant.name}}<br>
    Address : {{restaurant.address}}<br>
    Style : {{restaurant.artStyle}} <br>
    Hours: {{openingHours}} <br>
    <br /><button type="submit" v-on:click ="goToReservation()" class="reservebtn">Reserve</button>
    <br />
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
.reservebtn {
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
.restaurantInfo {
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