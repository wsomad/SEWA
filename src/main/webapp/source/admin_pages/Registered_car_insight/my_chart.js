var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['Hatchback', 'Sedan', 'SUV', 'Coupe', 'Pickup'],
      datasets: [{
        label: '# of Personal',
        data: [15, 19, 9, 5, 22],
        backgroundColor: 'rgba(255, 99, 132, 0.2)',
        borderColor: 'rgba(255, 99, 132, 1)',
        borderWidth: 1
      }, {
        label: '# of Company',
        data: [10, 22, 10, 17, 7],
        backgroundColor: 'rgba(153, 102, 255, 0.2)',
        borderColor: 'rgba(153, 102, 255, 1)',
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }


  });