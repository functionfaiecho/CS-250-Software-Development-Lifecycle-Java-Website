"use client";

import { useEffect, useState } from "react";
import { fetchDestinations, Destination } from "../api/destinations";

const Countries: React.FC = () => {
  const [destinations, setDestinations] = useState<Destination[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  // List of countries to display
  const targetCountries = ["Jakarta", "Dubai", "Auckland", "Vienna", "Pulau Tioman"];

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
          className="bg-white shadow-lg rounded-lg overflow-hidden w-full md:w-3/4 lg:w-2/3 mb-6"
        >
          <div className="p-6">
            <h2 className="text-2xl font-bold mb-4 text-blue-500">
              <a href={destination.Link} target="_blank" rel="noopener noreferrer">
                {destination.Destination}, {destination.Country}
              </a>
            </h2>
            <p className="text-gray-700 text-lg">{destination.Description}</p>
          </div>
        </div>
      ))}
    </div>
  );
};

export default Countries;
