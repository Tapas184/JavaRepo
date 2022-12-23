<script language="JavaScript">
	function validate(frm) {
		document.getElementById("pnameError").innerHTML = "";
		document.getElementById("paddrsError").innerHTML = "";
		document.getElementById("pageError").innerHTML = "";
		document.getElementById("pgenderError").innerHTML = "";
		//create variables
		let cname = frm.pname.value;
		let addrs = frm.paddrs.value;
		let age = frm.page.value;
		let gender = frm.pgender.value;
		let flag = true;
		//write bussiness logic
		if (cname == "") { //logic for name field
			//alert("Kindly enter name");
			document.getElementById("pnameError").innerHTML = "Error:Enter Person Name";
			frm.pname.focus();
			flag = false;
		}
		if (addrs == "") { // logic for address field
			//alert("Enter your address ");
			document.getElementById("paddrsError").innerHTML = "Error:Enter your address";
			frm.paddrs.focus();
			flag = false;
		} else if (addrs.length <= 10) { //logic for address length check
			//alert("Kindly Enter address more than 10 characters");
			document.getElementById("paddrsError").innerHTML = "Error:Kindly Enter address more than 10 characters";
			frm.paddrs.focus();
			flag = false;
		}
		if (isNaN(age)) { // logic for age 
			//alert("Kindly Enter numeric value");
			document.getElementById("pageError").innerHTML = "Error:Kindly Enter numeric value";
			frm.page.focus();
			flag = false;
		} else if (age<=0 || age>125) {
			//alert("kindly enter age between 1 to 125");
			document.getElementById("pageError").innerHTML = "Error:Kindly Enter numeric value";
			frm.page.focus();
			flag = false;
		} else if (age == "") {
			document.getElementById("pageError").innerHTML = "Error:kindly enter age between 1 to 125";
			frm.page.focus();
			flag = false;
		}
		if (gender == "") {
			//alert("kindly select your gender");
			document.getElementById("pgenderError").innerHTML = "Error:kindly select your gender";
			flag = false;
		}
		return flag;
	}
</script>