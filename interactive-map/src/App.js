import React, { useState } from "react";
import { ComposableMap, Geographies, Geography, ZoomableGroup } from "react-simple-maps";
import "./App.css";

// Path to your GeoJSON file in the public directory
const geoUrl = "/countries.geojson"; // Make sure this matches the location in your 'public' folder

function App() {
  const [hoveredCountry, setHoveredCountry] = useState(""); // State to store the hovered country
  const [coordinates, setCoordinates] = useState({ x: 0, y: 0 }); // State to store the mouse coordinates for positioning the tooltip
  const [zoom, setZoom] = useState(1); // State to manage zoom level

  // Handle mouse scroll to zoom in or out
  const handleWheel = (event) => {
    if (event.deltaY > 0) {
      // Scroll down (zoom out)
      setZoom((prevZoom) => Math.max(prevZoom - 0.1, 0.5)); // Zoom out but don't go below 0.5
    } else {
      // Scroll up (zoom in)
      setZoom((prevZoom) => Math.min(prevZoom + 0.1, 3)); // Zoom in but don't go above 3
    }
  };

  const handleMouseEnter = (geo, event) => {
    setHoveredCountry(geo.properties.ADMIN); // Set the country name on hover
    setCoordinates({
      x: event.clientX, // Get the mouse x-coordinate
      y: event.clientY, // Get the mouse y-coordinate
    });
  };

  const handleMouseLeave = () => {
    setHoveredCountry(""); // Reset the country name on mouse leave
  };

  return (
    <div className="App">
      <h1>Interactive Map</h1>
      <div className="map-container" onWheel={handleWheel}>
        <ComposableMap projection="geoMercator" width={1000} height={600}>
          <ZoomableGroup zoom={zoom}>
            <Geographies geography={geoUrl}>
              {({ geographies, error }) => {
                if (error) {
                  return <p>Error loading map data</p>;
                }
                if (!geographies.length) {
                  return <p>Loading map...</p>;
                }
                return geographies.map((geo) => (
                  <Geography
                    key={geo.rsmKey}
                    geography={geo}
                    onMouseEnter={(event) => handleMouseEnter(geo, event)} // Set the country name on hover
                    onMouseLeave={handleMouseLeave} // Reset the country name on mouse leave
                    style={{
                      default: { fill: "#D6D6DA", outline: "none" },
                      hover: { fill: "#F53", outline: "none" },
                      pressed: { fill: "#E42", outline: "none" },
                    }}
                  />
                ));
              }}
            </Geographies>
          </ZoomableGroup>
        </ComposableMap>
      </div>

      {hoveredCountry && (
        <div
          className="tooltip"
          style={{
            left: coordinates.x + 10, // Position slightly to the right of the mouse
            top: coordinates.y + 10, // Position slightly below the mouse
          }}
        >
          {hoveredCountry}
        </div>
      )}
    </div>
  );
}

export default App;
