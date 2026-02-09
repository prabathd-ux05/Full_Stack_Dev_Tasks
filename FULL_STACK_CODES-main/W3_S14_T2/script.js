const generateReceipt = (price, tip) => {
    const total = price + tip;
    console.log(`The total bill amount is ₹${total}`);
};

generateReceipt(500, 50);
