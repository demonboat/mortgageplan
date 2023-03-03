import React, { Component } from 'react';
import TableView from './TableView'
import { ThemeProvider, createTheme } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import FormView from './FormView';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      rows: []
    }
  }

  componentDidMount() {
      fetch("http://localhost:8080/api/v1/prospects/")
      .then(response => response.json())
      .then(json => this.setState({ rows: json }))
  }

  render() {
    const darkTheme = createTheme({
      palette: {
        mode: 'dark',
      },
    });
    return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
        <FormView />
        <TableView rows={this.state.rows}/>
    </ThemeProvider>
    );
  }
}

export default App;
