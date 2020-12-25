let offer_form = document.getElementById('offer-validation');

(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
      .forEach(function (form) {
        form.addEventListener('submit', function (event) {
          if (!form.checkValidity()) {
            event.preventDefault()
            event.stopPropagation()
          }

          form.classList.add('was-validated')
        }, false)
      });
})()

offer_form.onsubmit = async (e) => {
  e.preventDefault();
  e.stopPropagation();
  if (offer_form.checkValidity() === true) {
    let form_data = new FormData();
    form_data.append('organisation', document.getElementById('organisation_name').value);
    form_data.append('profile', document.getElementById('profile').value);
    form_data.append('description', document.getElementById('description').value);
    form_data.append('intake', document.getElementById('intake').value);
    form_data.append('minimum_grade', document.getElementById('grades').value);
    console.log(form_data);
    let sp = document.getElementsByName('sp');
    let str1 = '';
    let i =  0;
    for ( i = 0; i < 4; i++) {
      //console.log(sp[i]);
      if ( sp[i].checked === true ) {
        //console.log(sp[i]);
        str1 += sp[i].value + " ";
        //console.log(str1);
      }
    }
    console.log(str1);
    form_data.append('specialisation', str1);

    //console.log(str1);

    let dm = document.getElementsByName('dm');
    let str2 = '';
    let j =  0;
    for ( j = 0; j < 4; j++) {
      if ( dm[j].checked === true ) {
        str2 += dm[j].value + " ";
      }
    }
    form_data.append('domain', str2);
    console.log(str2);

    let response = await fetch('api/placement', {
      method: 'POST',
      body: form_data
    });
    let result = await response;

    if (result['status'] === 203) {

      document.getElementById("offer-success").style.display = "none";
      document.getElementById("offer-alert").style.display = "block";

    } else {
      document.getElementById("offer-alert").style.display = "none";
      document.getElementById("offer-success").style.display = "block";
      location.href = "success.html";
    }
    console.log(result);
  }
  course_form.classList.add('was-validated');
};