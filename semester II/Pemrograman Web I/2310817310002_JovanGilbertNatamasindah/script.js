// const Name = document.querySelector(".name")
// const Email = document.querySelector(".email")
// const Button = document.querySelector(".btn")

// Button.addEventListener('click', function() {
//     if(Name.value == "" && Email.value == "") {
//         alert("Please fill in all fields")
//     }
//     else {
//         alert("Form submitted succesfully!")
//     }
// })

$(".btn").on('click', function() {
    if($(".name").val() == "" && $(".email").val() == "" && $(".textarea").val() == "") {
        alert("Please fill in all fields")
    }
    else {
        alert("Form submitted succesfully!")
    }
})