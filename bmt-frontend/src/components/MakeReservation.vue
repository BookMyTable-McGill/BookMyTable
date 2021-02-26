<template>
<div class="row">
<div class="column">
  <h3 onload="maximum()">Book your table!</h3>
  <form>
  <form>
    <label class="field" for="quantity">Group Size </label>
    <input type="number" id="quantity" name="quantity" min="1" max="10" v-model="quantity">
    </form>
    <form>
  <label class="field" for="date">Pick a date:</label>
  <input type="date" id="date" name="date" v-model="date">
  </form>
  <form>
  <label class="field" for="appt">Pick a time</label>
  <input type="time" id="appt" name="appt" min="09:00" max="18:00" v-model="appt" >
  </form>
  <form>
  <label class="field" for="table">Pick a table</label>
  <select id="table" name="table" v-model='table'>
     <option v-for="table in tables" v-bind:value="{ id: table.id }" :key="table.tableNumber"> {{table.tableNumber}}</option>
  </select>
</form>
    <button type="submit" class="button" @click="createReservation(quantity,date,appt,table)">Make Reservation</button>
    </form>

</div>
<div class="column">
  <h3>Restaurant's table layout</h3>
  <img src="" alt="Insert restaurant's table layout">
</div>
</div>
</template>

<style>
.button{
  background-color: #e7e7e7; /* Green */
   border: none;
   color: black;
   padding: 15px 32px;
   text-align: center;
   text-decoration: none;
   display: inline-block;
   font-size: 16px;
   cursor: pointer;
   margin-top: 50px;
}

.column{
  padding-top: 25px;
  padding-left: 200px;
  float: center;
  width: 50%;
}
.field{
  padding-top: 25px;
}
</style>

<script src="./javascript/makeReservation.js">
</script>
