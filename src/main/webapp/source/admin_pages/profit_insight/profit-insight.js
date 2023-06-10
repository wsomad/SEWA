document.addEventListener("DOMContentLoaded", function() {
  const ctx = document.getElementById('lineChart');

  // Generate random profit values within the range of 5,000 to 10,000
  const randomProfits = Array.from({ length: 7 }, () =>
    Math.floor(Math.random() * 2001) + 900
  );

  new Chart(ctx, {
    type: 'line',
    data: {
      labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
      datasets: [{
        label: 'Profits in $',
        data: randomProfits,
        backgroundColor: '#F9F9F8',
        borderColor: '#F86A12',
        pointBackgroundColor: '#252525',
        pointBorderColor: '#F9F9F8',
        pointRadius: 5,
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true,
          ticks: {
            min: 5000,
            max: 10000,
            stepSize: 1000,
            callback: function(value, index, values) {
              return value + ' $';
            },
            font: {
              family: "'Montserrat', sans-serif"
            }
          }
        }
      },
      plugins: {
        tooltip: {
          mode: 'index',
          intersect: false,
        }
      }
    }
  });
});