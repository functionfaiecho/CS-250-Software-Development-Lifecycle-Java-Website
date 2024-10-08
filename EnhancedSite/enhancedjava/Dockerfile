# Use an official Node.js image as the base
FROM node:18-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the package.json and package-lock.json files to the container
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of application code to the container
COPY . .

# Expose the port Next.js will run on
EXPOSE 3000

# Start the app using the development command
CMD ["npm", "run", "dev"]