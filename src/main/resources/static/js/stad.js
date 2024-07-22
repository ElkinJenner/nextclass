document.addEventListener('DOMContentLoaded', (event) => {
    const ctx = document.getElementById('myChart').getContext('2d');
    const names = ['Carlos', 'Pedro', 'Maria', 'Rosa', 'Juan'];
    const ages = [24, 10, 54, 51, 15];

    const myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: names,
            datasets: [{
                label: 'Edad',
                data: ages,
                backgroundColor: [
                    '#1b84ff',
                    '#ea641d',
                    '#fedd64',
                    '#d3adfd',
                    '#31d1ab'
                ],
                borderWidth: 1.5
            }]
        }
    });
});
