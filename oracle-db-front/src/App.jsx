import React from "react";
import './App.scss'
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";

import { createTheme, ThemeProvider } from '@mui/material';

import OracleTable from "./pages/OracleTable/OracleTable";


function App() {


  const theme = createTheme({
    palette: {
      mode: 'dark',
      // primary: {
      //   // light: will be calculated from palette.primary.main,
      //   main: '#3F7E6F',
      //   // dark: will be calculated from palette.primary.main,
      //   // contrastText: will be calculated to contrast with palette.primary.main
      // },
    },
    typography: {
      fontFamily: 'Montserrat',
      fontSize: 13
    },
    components: {
      MuiOutlinedInput: {
        styleOverrides: {
          root: {
            // minHeight: 'max-content',
            // maxHeight: '30px',
            // fontSize: '9px',
            backgroundColor: '#0D0F11'
          },
          focused: {
            backgroundColor: '#0D0F11'
          },
          input: {
            '&:-webkit-autofill': {
              WebkitBoxShadow: '0 0 0 100px #0D0F11 inset'
            
            }
          }
        }
      }
    }
  })
  return (
    <div className="App">
      <ThemeProvider theme={theme}>
        <Router>
          <Routes>
            <Route path='/' element={
              <>
              <OracleTable/>
              </>
            }/>
          </Routes>
        </Router>
      </ThemeProvider>
    </div>
  )
}

export default App
