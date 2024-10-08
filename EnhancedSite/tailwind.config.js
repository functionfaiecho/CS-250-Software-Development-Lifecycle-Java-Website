/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/**/*.{js,ts,jsx,tsx}',
    './pages/**/*.{js,ts,jsx,tsx}',
    './components/**/*.{js,ts,jsx,tsx}',
    './app/**/*.{js,ts,jsx,tsx}'  // Add this line
  ],
  theme: {
    extend: {
      colors: {
        theme: '#FEF9EF',
        linkedText: '#FE6D73',
        text: '#114b5f',
      },
    },
  },
  plugins: [],
}
