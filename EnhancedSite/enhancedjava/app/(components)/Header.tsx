"use client";

const Header: React.FC = () => {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center', height: '150px' }}>
      <h1 style={{ fontSize: '3rem', fontWeight: 'bold', marginBottom: '2px' }}>Top Five Destinations List</h1>
      <h2 style={{ fontSize: '1.5rem', fontStyle: 'italic', marginTop: '0' }}>(in CS 250 anyway.)</h2>
    </div>
  );
};

export default Header;
