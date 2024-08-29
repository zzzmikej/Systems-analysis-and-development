// index.js

function Greeting(props) {
    return <h1>Hello, {props.name}!</h1>;
  }
  
  function App() {
    return (
      <div>
        <Greeting name="Mundo" />
      </div>
    );
  }
  
  ReactDOM.render(<App />, document.getElementById('root'));
  