function orderPizza(pizzaType) {
    return new Promise((resolve, reject) => {
        console.log("Placing your pizza order...");

        setTimeout(() => {
            if (pizzaType === "Margherita" || pizzaType === "Pepperoni") {
                resolve(`✅ Your ${pizzaType} pizza is ready! Enjoy 🍕`);
            } else {
                reject("❌ Sorry, this pizza type is not available.");
            }
        }, 2000); 
    });
}


orderPizza("Margherita")
    .then((message) => {
        console.log(message);
    })
    .catch((error) => {
        console.log(error);
    });
