"use client";

import { useEffect, useState } from "react";
import { fetchDestinations, Destination } from "../api/destinations";

const Countries: React.FC = () => {
  const [destinations, setDestinations] = useState<Destination[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  // List of countries to display
  const targetCountries = ["Singapore", "Dubai", "Auckland", "Vienna", "Rome"];

  useEffect(() => {
    const loadDestinations = async () => {
      try {
        // Fetch all destinations using the function from api/destinations.ts
        const allDestinations = await fetchDestinations();
        // Filter to include only the desired destinations
        const filteredDestinations = allDestinations.filter(destination =>
          targetCountries.includes(destination.Destination)
        );
        setDestinations(filteredDestinations);
        setLoading(false);
      } catch (err: any) {
        setError(err.message);
        setLoading(false);
      }
    };

    loadDestinations();
  }, []);

  // Function to map country name to image file
  const getImageUrl = (destination: string): string => {
    switch (destination) {
      case "Singapore":
        return "/Singapore.jpg";
      case "Dubai":
        return "/Dubai.jpg";
      case "Auckland":
        return "/Auckland.jpg";
      case "Vienna":
        return "/Vienna.jpg";
      case "Rome":
        return "/Rome.jpg";
      default:
        return ""; // If no image is available, return an empty string or handle as needed
    }
  };

  // Display loading state
  if (loading) {
    return <p>Loading...</p>;
  }

  // Display error message
  if (error) {
    return <p>Error: {error}</p>;
  }

  // Render the destination cards
  return (
    <div className="min-h-screen p-8 flex flex-col items-center">
      {destinations.map((destination) => (
        <div 
          key={destination._id} 
          className="bg-white shadow-lg rounded-lg overflow-hidden w-full md:w-3/4 lg:w-2/3 mb-6 flex"
        >
          <div className="w-1/3">
            {/* Add image based on the destination */}
            {getImageUrl(destination.Destination) && (
              <img
                src={getImageUrl(destination.Destination)} // Dynamic image URL based on the destination
                alt={destination.Destination}
                className="w-full h-auto object-cover"
              />
            )}
          </div>
          <div className="p-6 flex-1">
            <h2 className="text-2xl font-bold mb-4 text-linkedText">
              <a href={destination.Link} target="_blank" rel="noopener noreferrer">
                {destination.Destination}, {destination.Country}
              </a>
            </h2>
            <p className="text-text text-lg">{destination.Description}</p>
          </div>
        </div>
      ))}
    </div>
  );
};

export default Countries;
