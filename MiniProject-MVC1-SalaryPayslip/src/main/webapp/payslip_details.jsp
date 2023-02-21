<%@ page import="com.nt.beans.*,com.nt.services.*"%>
<!-- creates and locate java bean id -->
<jsp:useBean id="emp" class="com.nt.beans.Employee" scope="request"/>

<!-- Write formdata to javaBean class object -->
<jsp:setProperty property="*" name="emp"/>

<!-- Create/locate service class object -->
<jsp:useBean id="service" class="com.nt.services.EmployeeService" scope="application"/>

<!-- Invok Business Method -->
<%
service.generatePayslip(emp);
%>
<!-- Read the inputs from java bean class obj and display on the browser -->
<h2 style="color: red;text-align: center" border="1">Employee PaySlip</h2>
<table align="center" bgcolor="pink" border="1">
<tr>
<td>Emp Name ::</td>
<td><jsp:getProperty property="name" name="emp"/></td>
</tr>
<td>Emp Address ::</td>
<td><jsp:getProperty property="eadd" name="emp"/></td>
</tr>
<td>Emp BasicSalary ::</td>
<td><jsp:getProperty property="basicSalary" name="emp"/></td>
</tr>
<td>Emp GrossSalary ::</td>
<td><jsp:getProperty property="grossSalary" name="emp"/></td>
</tr>
</tr>
<td>Emp NetSalary ::</td>
<td><jsp:getProperty property="netSalary" name="emp"/></td>
</tr>
</table>

<h3 style="text-align: center"><a href="employee_details.html">Home</a></h3>