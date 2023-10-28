// Define an async function to load cart items
async function loadCartItems() {
  const response = await fetch('http://localhost:8083/products/all');
  if (response.ok) {
    const cartItems = await response.json();
    displayCartItems(cartItems);
  } else {
    console.error('Failed to load cart items');
  }
}

// Function to display cart items in the HTML table
function displayCartItems(cartItems) {
  const cartItemsTable = document.getElementById('cart-items');
  const cartItemsBody = cartItemsTable.querySelector('tbody');
  const totalPriceCell = document.getElementById('total-amount');
  cartItemsBody.innerHTML = ''; // Clear the table body

  let total = 0; // Initialize total price

  // Iterate through the cart items and add them to the table
  cartItems.forEach((item) => {
    const row = cartItemsBody.insertRow();
    row.innerHTML = `
      <td>${item.id}</td>
      <td>${item.name}</td>
      <td>${item.price}</td>
      <td>
        <button class="btn btn-danger" onclick="deleteCartItem(${item.id})">Delete</button>
        <button class="btn btn-success" onclick="updateCartItem(${item.id})">Update</button>

      </td>
    `;

    // Calculate the total price
    total += item.price;
  });

  // Display the total price
  totalPriceCell.textContent = total.toFixed(2); // Assuming prices are in decimal format (e.g., 2 decimal places)
}

// Define an async function to delete a cart item
async function deleteCartItem(itemId) {
  const response = await fetch(`http://localhost:8083/products/delete/${itemId}`, {
    method: 'DELETE',
  });
  if (response.ok) {
    console.log('Cart item deleted successfully');
    loadCartItems(); // Refresh the cart items after deletion
  } else {
    console.error('Error deleting cart item');
  }
}

// Define an async function to update a cart item
async function updateCartItem(itemId) {
  // Assuming you have form inputs to capture the updated data
  const updatedName = document.getElementById('update-name').value;
  const updatedPrice = document.getElementById('update-price').value;

  // Create an object with the updated data
  const updatedData = {
    name: updatedName,
    price: updatedPrice,
  };

  const response = await fetch(`http://localhost:8083/products/save/${itemId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(updatedData), // Send the updated data as JSON
  });

  if (response.ok) {
    console.log('Cart item updated successfully');
    loadCartItems(); // Refresh the cart items after updating
  } else {
    console.error('Error updating cart item');
  }
}


// Load cart items when the page is loaded
document.addEventListener('DOMContentLoaded', () => {
  loadCartItems();
});
