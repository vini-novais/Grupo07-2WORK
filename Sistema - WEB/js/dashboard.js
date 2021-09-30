// GRÁFICO LIKES EM POSTAGENS
new Chart(document.getElementById("grafico-likes"), {
    type: 'line',
    data: {
        labels: ["07-08", "14-08", "21-08", "28-08", "04-09", "11-09", "18-09", "25-09", "02-10", "09-10"],
        datasets: [{
            data: [20, 100, 110, 146, 226, 370, 500, 567, 700, 900],
            label: "Curtidas",
            borderColor: "#3e95cd",
            fill: false
        },]
    },
});
// FIM GRÁFICO LIKES EM POSTAGENS
// GRÁFICO VISUALIZAÇÕES EM POSTAGENS
new Chart(document.getElementById("grafico-visitas"), {
    type: 'line',
    data: {
        labels: ["07-08", "14-08", "21-08", "28-08", "04-09", "11-09", "18-09", "25-09", "02-10", "09-10"],
        datasets: [{
            data: [100, 196, 370, 998, 1200, 1800, 2678, 3215, 4672, 5671],
            label: "Visualizações",
            borderColor: "#3e95cd",
            fill: false
        },]
    },
});
// FIM GRÁFICO VISUALIZAÇÕES EM POSTAGENS