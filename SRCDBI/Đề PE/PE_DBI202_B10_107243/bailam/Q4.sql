select c.custName,c.cusAddress,St.serviceTicketID,St.dateReturned
from Customer c
join ServiceTicket St on c.custID = St.custID
order by St.dateReturned DESC

-- custname , cusaddress, serviceTicktID,dateReturned