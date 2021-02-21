<template>
  <div class="container">
    <h1>Map of Reservation</h1>
    <datetime format="DD-MM-YYYY h:i:s" width="120px" v-model="datetime" />
    <button v-on:click="getAllTables()">Get Tables</button>

    <div class="tables-map">
      <div v-for="row in tablesMap" :key="row" class="tables-row">
        <div v-for="cell in row" :key="cell" class="table">
          <div v-if="cell === null" class="cell" />

          <div v-else-if="cell.reserved === true" class="cell table-reserved">
            {{ cell.tableNumber }}
          </div>

          <div v-else class="cell table-not-reserved">
            {{ cell.tableNumber }}
          </div>
        </div>
      </div>

      <div style="position: absolute; bottom: 0; right: 12px">
        <div style="display: flex; align-items: center">
          <div class="legend" style="background-color: lightgreen" />
          <h3 style="margin: 0">Reserved</h3>
        </div>
        <div style="display: flex; align-items: center">
          <div class="legend" style="background-color: lightgray" />
          <h3 style="margin: 0">Not reserved</h3>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="./javascript/viewMapReservation.js" />

<style>
.tables-map {
  position: relative;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.tables-row {
  display: flex;
}
.cell {
  width: 60px;
  height: 60px;
  margin: 12px;
  border-radius: 4px;

  display: flex;
  align-items: center;
  justify-content: center;

  font-size: 24px;
  font-weight: bolder;
}
.table-reserved {
  background-color: lightgreen;
}
.table-not-reserved {
  background-color: lightgray;
}

.legend {
  width: 12px;
  height: 12px;
  margin-right: 12px;
}
</style>

        
        