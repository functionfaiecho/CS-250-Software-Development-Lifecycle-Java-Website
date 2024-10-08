import Header from "./(components)/Header";
import Countries from "./(components)/Countries";

export default function Home() {
  return (
    <div className="bg-theme min-h-screen">
      <Header />
      <Countries />
    </div>
  );
}
