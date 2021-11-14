import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSum } from "types/sale";
import { BASE_URL } from "utils/requests";

type ChartData = {
  labels: string[];
  series: number[];
};

function DonutChart() {
  /*
    Hook: useState
    Manter estado no componente
   */
  const [chartData, setChartData] = useState<ChartData>({
    labels: [],
    series: [],
  });

  // FORMA ERRADA
  // let chartData: ChartData = { labels: [], series: [] };

  /*  
    Hook: useEffect
    Executar algo na instanciação ou destruição do componente, observar estado
  */
  useEffect(() => {
    axios.get(`${BASE_URL}/sales/getSumBySeller`).then((response) => {
      const data = response.data as SaleSum[];

      const myLabels = data.map((s) => s.sellerName);
      const mySeries = data.map((s) => s.sum);

      setChartData({ labels: myLabels, series: mySeries });
    });
  }, []);

  /*const mockData = {
    series: [477138, 499928, 444867, 220426, 473088],
    labels: ["Anakin", "Barry Allen", "Kal-El", "Logan", "Padmé"],
  };*/

  const options = {
    legend: {
      show: true,
    },
  };

  return (
    <>
      <Chart
        options={{ ...options, labels: chartData.labels }}
        series={chartData.series}
        type="donut"
        height="240"
      />
    </>
  );
}

export default DonutChart;
