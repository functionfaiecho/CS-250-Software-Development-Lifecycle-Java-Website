export interface Destination {
    _id: string;
    Destination: string;
    Country: string;
    Description: string;
    Link: string;
  }
  
  // Fetch destinations from the API
  export const fetchDestinations = async (): Promise<Destination[]> => {
    const response = await fetch("https://countriesapi.crabcakes.dev/destinations");
  
    if (!response.ok) {
      throw new Error("Failed to fetch destinations.");
    }
  
    const data: Destination[] = await response.json();
    return data;
  };