<template>
        <div class="restaurant-grid1">
            <a :href="`/#/Restaurant/${restaurant.id}`"> <img class="restaurant-grid1-img" :src="restaurant.logo"> </a>
            <div class="restaurant-grid1-info">
                <div class="passline"></div>
                <a :href="`/#/Restaurant/${restaurant.id}`" class="viewL"><span style="font-weight: bold">{{restaurant.logo}}</span> </a>
                <div> By <a :href="`/#/Name/${restaurant.name}`" class="viewA"><span style="font-weight: bold">{{restaurant.name}}</span></a> </div>
                <div class="passline"></div>
                <div> {{restaurant.price}}$</div>
            </div>
        </div>
</template>

<style>

a:active, a:visited {
    border:0 none
}

.restaurant-grid1 {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    margin-bottom: 1em;
    padding: 0.5em 0.5em 0.5em 0.5em;
}

.restaurant-grid1-img {
    height: 15em;
    margin-right: 1em;
    border: 5px solid #00ff80;
}

.restaurant-grid1-img:hover {
    border: 5px solid #FFFFFF;
}

.restaurant-grid1-info {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    text-align: left;
}

.viewL {
    display: flex;
    font-family: Raleway;
    color: #2b2d42;
}
.viewL:hover {
  color: #2b2d42;
}

</style>