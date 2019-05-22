<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Booking Confirmation</title>
</head>

<body>
<div style="font-size: 28px; color:coral;margin-left: 20%">
		<b>Dear ${name},</b>
</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center" valign="top""
				><br> <br>
				<table width="60%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="center" valign="top" 
							style="font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #000000; padding: 0px 15px 10px 15px;">
							
							<div style="font-size: 28px; color:coral;">
								<b>Your tickets are reserved successfully...!</b>
							</div>
							
							<div style="font-size: 24px; color: #555100;">
								<br> Please make sure all the details are correct and if not, inform us <b style="color: red">as soon as possible..!</b> <br>
							</div>
							<br/><br/><br/><br/>
							<div>


								<table width="100%" align="center" style="border-spacing: 20px 5px;font-weight: bold;color: green;font-size: 21px">
									<tbody>
										<tr>
											<td align="right">Date</td>
											<td align="left">${date}</td>
										</tr>
										<tr>
											<td align="right">From</td>
											<td align="left">${from}</td>
										</tr>
										<tr>
											<td align="right">To</td>
											<td align="left">${to}</td>
										</tr>
										<tr>
											<td align="right">Arrival Time</td>
											<td align="left">${arrival}</td>
										</tr>
										<tr>
											<td align="right">Departure Time</td>
											<td align="left">${departure}</td>
										</tr>
										<tr>
											<td align="right">No of Seats</td>
											<td align="left">${noOfSeats}</td>
										</tr>
										<tr>
											<td align="right">Booked Seats</td>
											<td align="left">${seatList}</td>
										</tr>
										<tr>
											<td align="right">Discount</td>
											<td align="left">${discount}</td>
										</tr>
										<tr>
											<td align="right">Final Cost</td>
											<td align="left">${cost}</td>
										</tr>
										
									</tbody>

								</table>

								<div style="font-size: 24px; color: red;">
								<br> Thank you very much for using our service</b> <br>
							</div>
						
							</div>
						</td>
					</tr>
				</table> <br> <br></td>
		</tr>
	</table>
</body>
</html>