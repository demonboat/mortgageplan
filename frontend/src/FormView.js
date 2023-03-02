import { TextField, Button, Grid, Stack, Link } from '@mui/material';
import React, { useState } from 'react';


function FormView() {
    const [customerName, setCustomerName] = useState("")
    const [totalLoan, setTotalLoan] = useState(0.0)
    const [interest, setInterest] = useState(0.0)
    const [years, setYears] = useState(0)
    const [status, setStatus] = useState("")

    const prospect = {
        customerName: customerName,
        totalLoan: totalLoan,
        interest: interest,
        years: years,
    }
 
    const handleSubmit = (event) => {
        event.preventDefault();
        fetch("http://localhost:8080/api/v1/prospects/new", {
            method: "post",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(prospect)
        }).then(response => setStatus(response.status))
        .catch(console.error);
    }

    if (status == "201") {
        window.location.reload();
    } 

    return (
        <Grid
        container
        spacing={0}
        direction="column"
        alignItems="center"
        justifyContent="center"
        style={{ minHeight: '100vh', minWidth: '80vh' }}>
        <Grid item xs={8}>
            <h1>Register a new Prospect</h1>
        </Grid>
        <Grid item xs={8}>
            <form onSubmit={handleSubmit}>
                <Stack spacing={1} sx={{marginBottom: 4}}>
                    <TextField
                        type="text"
                        variant="outlined"
                        color="secondary"
                        label="Name"
                        onChange={e => setCustomerName(e.target.value)}
                        value={customerName}
                        fullWidth
                        required/>
                    
                    <TextField
                        type="number"
                        variant="outlined"
                        color="secondary"
                        label="Loan Amount"
                        onChange={e => setTotalLoan(e.target.value)}
                        value={totalLoan}
                        fullWidth
                        required />
                    <TextField
                        type="number"
                        variant='outlined'
                        color='secondary'
                        label="Interest"
                        onChange={e => setInterest(e.target.value)}
                        value={interest}
                        fullWidth
                        required
                        sx={{mb: 4}} />
                    <TextField
                        type="number"
                        variant='outlined'
                        color='secondary'
                        label="Years"
                        onChange={e => setYears(e.target.value)}
                        value={years}
                        required
                        fullWidth
                        sx={{mb: 4}} />
                    <Button variant="contained" color="secondary" type="submit">Submit new Prospect</Button>
                </Stack>
            </form>
        </Grid>
            <h2><b>Scroll down for Table</b></h2>
        </Grid>
    );
}

export default FormView;