/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{js,ts,jsx,tsx}'], // Add paths to your components
  theme: {
    extend: {
      colors: {
        background: '#FEF9EF',
        linkedText: '#FE6D73',
        text: '#114b5f',
      },
    },
  },
  plugins: [],
}
