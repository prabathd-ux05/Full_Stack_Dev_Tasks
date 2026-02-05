const products = [
    { name: "Nike Runner", price: 4500, brand: "Nike", color: "red", rating: 4 },
    { name: "Adidas Pro", price: 3500, brand: "Adidas", color: "black", rating: 5 },
    { name: "Puma Flex", price: 2800, brand: "Puma", color: "blue", rating: 3 },
    { name: "Nike Air", price: 5000, brand: "Nike", color: "black", rating: 5 },
    { name: "Adidas Lite", price: 2200, brand: "Adidas", color: "red", rating: 4 }
]

const productList = document.getElementById("productList")
const priceRange = document.getElementById("priceRange")
const priceValue = document.getElementById("priceValue")
const brandFilter = document.getElementById("brandFilter")
const ratingFilter = document.getElementById("ratingFilter")
let selectedColor = "all"

function displayProducts(items) {
    productList.innerHTML = ""
    items.forEach(p => {
        productList.innerHTML += `
            <div class="product">
                <h3>${p.name}</h3>
                <span>₹${p.price}</span>
                <span>${p.brand}</span>
                <span>${p.rating}★</span>
            </div>
        `
    })
}

function filterProducts() {
    let filtered = products.filter(p =>
        p.price <= priceRange.value &&
        (brandFilter.value === "all" || p.brand === brandFilter.value) &&
        (selectedColor === "all" || p.color === selectedColor) &&
        p.rating >= ratingFilter.value
    )
    displayProducts(filtered)
}

priceRange.oninput = () => {
    priceValue.textContent = `Up to ₹${priceRange.value}`
    filterProducts()
}

brandFilter.onchange = filterProducts
ratingFilter.onchange = filterProducts

document.querySelectorAll(".color-box button").forEach(btn => {
    btn.onclick = () => {
        selectedColor = btn.dataset.color
        filterProducts()
    }
})

displayProducts(products)
