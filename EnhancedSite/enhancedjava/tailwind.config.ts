import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        theme: '#FEF9EF',       // Main theme colour
        linkedText: '#FE6D73',  // Colour for linked text
        text: '#114b5f',        // General text colour
      },
    },
  },
  plugins: [],
};

export default config;
