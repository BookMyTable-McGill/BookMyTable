<script src="./javascript/createRestaurant.js"> </script>
<template>
  <div class="container">
    <h1>Create Restaurant</h1>
    <p>Please fill in this form to create a restaurant.</p>
    <hr />

    <label id="restoName" for="restoName"><b>Restaurant Name</b></label
    ><br />
    <input type="text" placeholder="Enter Restaurant Name" name="restoName" id="restoName" />

    <br /><label id="address" for="address"><b>Address</b></label
    ><br />
    <input type="text" placeholder="Enter Address" name="address" id="address" />

    <br /><label id="hours" for="hours"><b>Operational Hours</b></label
    ><br />
    <div class="opHours">
      
       <div class="days"><b> Days </b> <p name="monday"> Monday </p> <p name="tuesday"> Tuesday </p> <p name="wednesday"> Wednesday </p> <p name="thursday"> Thursday </p> <p name="friday"> Friday </p> <p name="saturday"> Saturday </p> <p name="sunday"> Sunday </p> </div>
  <div class="oTime"> <b> Opening Time </b>
    <input type="time"  name="monOpTime" id="monOpTime"/>
    <input type="time"  name="tuOpTime" id="tuOpTime"/>
    <input type="time"  name="wedOpTime" id="wedOpTime"/>
    <input type="time"  name="thuOpTime" id="thuOpTime"/>
    <input type="time"  name="friOpTime" id="friOpTime"/>
    <input type="time"  name="satOpTime" id="satOpTime"/>
    <input type="time"  name="sunOpTime" id="sunOpTime"/>

  </div>
  <div class="cTime"> <b> Closing Time </b>
    <input type="time"  name="monCloTime" id="monCloTime"/>
    <input type="time"  name="tuCloTime" id="tuCloTime"/>
    <input type="time"  name="wedCloTime" id="wedCloTime"/>
    <input type="time"  name="thuCloTime" id="thuCloTime"/>
    <input type="time"  name="friCloTime" id="friCloTime"/>
    <input type="time"  name="satCloTime" id="satCloTime"/>
    <input type="time"  name="sunCloTime" id="sunCloTime"/>
      
</div>
      </div>

    <br /><label id="bookTime" for="bookTimeHours"><b>Estimated Reservation Length</b></label
    ><br />
     <select name="bookTimeH" id="bookTimeH">
      <option value="0.5">0.5 hours</option>
      <option value="1">1 hours</option>
      <option value="1.5">1.5 hours</option>
      <option value="2">2 hours</option>
      <option value="2.5">2.5 hours</option>
      <option value="3">3 hours</option>
      <option value="3.5">3.5 hours</option>
      <option value="4">4 hours</option>
      <option value="4.5">4.5 hours</option>
      <option value="5">5 hours</option>
      <option value="5.5">5.5 hours</option>
      <option value="6">6 hours</option>
      <option value="6.5">6.5 hours</option>
      <option value="7">7 hours</option>
      <option value="7.5">7.5 hours</option>
      <option value="8">8 hours</option>
      <option value="8.5">8.5 hours</option>
      <option value="9">9 hours</option>
      <option value="9.5">9.5 hours</option>
      <option value="10">10 hours</option>
    </select>

    <br /><label id="menu" for="menu"><b>Menu</b></label
    ><br />
    <input type="text" placeholder="Enter Menu Link" name="menu" id="menu"
    />

    <br /><label id="price" for="price"><b>Price</b></label
    ><br />
    <select name="price" id="price">
      <option value="$">$</option>
      <option value="$$">$$</option>
      <option value="$$$">$$$</option>
    </select>

    <br /><label id="cuisine" for="cuisine"><b>Cuisine</b></label
    ><br />
    <input type="text" placeholder="Enter Cuisine Type" name="cuisine" id="cuisine"
    />

    <br /><label id="foodOptions" for="foodOptions"><b>Food Options</b></label
    ><br />
    <input type="text" placeholder="Enter Food Options" name="foodOptions" id="foodOptions"
    />

    <br /><label id="layout" for="layout"><b>Restaurant Layout</b></label
    ><br />
    <input type="text" placeholder="Enter Layout Link" name="layout" id="layout"
    />

    <button type="submit" v-on:click ="createRestaurant(restoName, address, hours, bookTimeH, menu, price, cuisine, foodOptions)"  class="createResto">Create Restauraunt</button>
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

.opHours {
  display:flex;
  flex-wrap: wrap;
  margin-left: 315px;
   

}
.oTime {
  width: 15%;
}
.oTime input{
  margin: 20px;
}
.cTime {
  width: 15%;
}

.cTime input{
  margin: 20px;
}

.days p[name="monday"], [name="tuesday"], [name="wednesday"], [name="thursday"], [name="friday"], [name="saturday"], [name="sunday"] {
 margin-top: 27px;
 margin-bottom: 45px;
}
/* Half-width input fields */
input[name="restoName"], [name="address"], [name="hours"], [name="menu"], [name="cuisine"], [name="foodOptions"], [name="layout"] {
  width: 50%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  border-radius: 5px;
  background: #f1f1f1;
}

input[type="text"]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}



select[name="price"],[name="bookTimeH"] {
  width: 25%;
  padding: 16px 20px;
  border: none;
  border-radius: 5px;
  margin: 5px 0 22px 0;
  background-color: #f1f1f1;
}

/* Set a style for the submit/register button */
.createResto {
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

.createResto:hover {
  opacity: 1;
}

label[id="restoName"] {
  right: 200px;
  position: relative;
}

label[id="address"] {
  right: 235px;
  position: relative;
}

label[id="hours"] {
  right: 200px;
  position: relative;
}

label[id="bookTimeHours"] {
  right: 213px;
  position: relative;
}

label[id="menu"] {
  right: 248px;
  position: relative;
}

label[id="cuisine"] {
  right: 238px;
  position: relative;
}

label[id="foodOptions"] {
  right: 215px;
  position: relative;
}

label[id="layout"] {
  right: 200px;
  position: relative;
}
</style>