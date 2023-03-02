import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Grid } from '@mui/material';



function TableView(props) {
    return (
      <Grid
      container
      spacing={0}
      direction="column"
      alignItems="center"
      justifyContent="center"
      style={{ minHeight: '100vh' }}>
     <Grid item xs={4}>
         <h1>Table View for Prospects</h1>
     </Grid>
     <Grid item xs={4}>
     <TableContainer component={Paper}>
       <Table sx={{ maxWidth: 1000 }} aria-label="simple table">
         <TableHead>
           <TableRow>
             <TableCell>Prospects</TableCell>
             <TableCell align="right">Total Loan&nbsp;(€)</TableCell>
             <TableCell align="right">Interest&nbsp;(%)</TableCell>
             <TableCell align="right">Years</TableCell>
             <TableCell align="right">Fixed Monthly Rate</TableCell>
             
           </TableRow>
         </TableHead>
         <TableBody>
           {props.rows.map((row) => (
             <TableRow
               key={row.customerName}
               sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
             >
               <TableCell component="th" scope="row">
                 {row.customerName}
               </TableCell>
               <TableCell align="right">{row.totalLoan}</TableCell>
               <TableCell align="right">{row.interest}</TableCell>
               <TableCell align="right">{row.years}</TableCell>
               <TableCell align="right">{row.fixedMonthlyRate.toPrecision(5)}</TableCell>
             </TableRow>
           ))}
         </TableBody>
       </Table>
     </TableContainer>
     </Grid>
     </Grid>
    );
}

export default TableView;