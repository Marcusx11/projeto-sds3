// Import do React não é mais necessário a partir da versão 17
import NavBar from 'components/NavBar';
import React from 'react';

function App() {
  return (
    <div className="App">
      <h1 className="text-primary">Olá, mundo!</h1>
      <NavBar />
    </div>
  );
}

export default App;
