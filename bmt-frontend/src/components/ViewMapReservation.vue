<template lang="en">
    <div class="container">
        <h1>Map of Reservation</h1>
        <button v-on:click="getAllTables()">Get Tables</button>

        <div v-for="row in tablesMap" :key="row" style="display: flex; background-color:'red'; width: 100%;">
            <div v-for="col in row" :key="col" style="margin: 8px; background-color:'green';">
                <h1 v-if="col === null">#</h1>
                <h1 v-else-if="col === true">R</h1>
                <h1 v-else>N</h1>
            </div>
        </div>
    </div>
</template>

<script src="./javascript/viewMapReservation.js" />

<style lang="en">
    
</style>

        
        