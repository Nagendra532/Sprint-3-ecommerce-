
class ItemController {
  constructor(currentId = 0) {
    this.currentId = currentId;
    this.items = [];
    this.loadFromLocalStorage();
    // localStorage.removeItem('cartProducts');
    // console.log(this.items);
  }

  addItem(product) {
    const existingProduct = this.items.find(item => item.id === product.id);
    if (existingProduct) {
        existingProduct.quantity += 1; // Increment the quantity
    } else {
        this.items.push({ ...product, quantity: 1 }); // Add a new product entry
    }
    console.log(this.items);
    // this.items = JSON.parse(localStorage.getItem('cart1')) || [];

    // Add the new item to the cart
    // cartItems.push(product);

    // Save the updated cart back to local storage
    localStorage.setItem('cart1', JSON.stringify(this.items));
    console.log(this.items);
    cart.save(product);
}

removeItem(productId) {
  const index = this.items.findIndex(item => item.id === productId);
  if (index !== -1) {
      this.items.splice(index, 1); // Remove the item from the cart
      this.saveToLocalStorage();
  }
}

loadFromLocalStorage() {
  const cartData = localStorage.getItem('cart1');
  this.items = cartData ? JSON.parse(cartData) : [];
}

saveToLocalStorage() {
    localStorage.setItem('cart1', JSON.stringify(this.items));
}
save({ image, name, price }) {
  if (image === null) {
    // Handle the case where the 'image' field is null, e.g., provide a default image
    image = 'default-image.jpg';
  }
  const data = { image, name, price };

  fetch('http://localhost:8083/products/save', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}


update({name, description, imageUrl}){
  //TODO implement this method
}

delete(itemId){
  //TODO implement this method
}

findById(itemId){
  //TODO implement this method
}


}

const cart = new ItemController();

function addToCart(productId, productName, price) {
  const product = {
    id: productId,
    name: productName,
    price: price,
    image: `images/product${productId}.jpg`
  };
  cart.addItem(product);
  // cart.save(product.image,product.name,product.price);
  // cart.save(product);
  console.log(`Product ${productName} added to cart.`);
}


// Sample products with image paths
const product1 = {
  id: 1,
  image: 'images/product1.jpg',
  name: 'Laptop',
  price: 30000,
  quantity: 1,
  
};

const product2 = {
  id: 2,
  image: 'images/product2.jpg',
  name: 'Apple iphone',
  price: 15000,
  quantity: 1,
  
};

const product3 = {
  id: 3,
  image: 'images/product3.jpg',
  name: 'Ear buds',
  price: 1500,
  quantity: 1,
};

// // Adding products to cart
// addToCart(product1.id, product1.image, product1.name, product1.price, product1.quantity);
// addToCart(product2.id, product2.image, product2.name, product2.price, product2.quantity);
// addToCart(product3.id, product3.image, product3.name, product3.price, product3.quantity);

console.log(cart.items);
