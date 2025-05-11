document.addEventListener('DOMContentLoaded', () => {
  const addToCartButtons = document.querySelectorAll('.add-to-cart');

  addToCartButtons.forEach(button => {
    button.addEventListener('click', () => {
      const name = button.getAttribute('data-name');
      const price = parseFloat(button.getAttribute('data-price'));

      let cart = JSON.parse(localStorage.getItem('cart')) || [];

      const existingProductIndex = cart.findIndex(item => item.name === name);
      if (existingProductIndex !== -1) {
        cart[existingProductIndex].quantity += 1;
      } else {
        cart.push({ name, price, quantity: 1 });
      }

      localStorage.setItem('cart', JSON.stringify(cart));
      alert(`${name} has been added to your cart.`);
    });
  });
});
