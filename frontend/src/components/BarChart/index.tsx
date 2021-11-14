import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSuccessRate } from "types/sale";
import { round } from "utils/format";
import { BASE_URL } from "utils/requests";

type SeriesData = {
  name: string;
  data: number[];
};

type ChartData = {
  labels: {
    categories: string[];
  };
  series: SeriesData[];
};

const BarChart = () => {
  const [chartData, setChartData] = useState<ChartData>({
    labels: {
      categories: [],
    },
    series: [
      {
        name: "% Sucesso",
        data: [],
      },
    ],
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/getSuccessBySeller`).then((response) => {
      const data = response.data as SaleSuccessRate[];

      const myLabels = data.map((s) => s.sellerName);
      const mySeries = data.map((s) => round((s.deals / s.visited) * 100.0, 1));

      setChartData({
        labels: {
          categories: myLabels,
        },
        series: [
          {
            name: "% Sucesso",
            data: mySeries,
          },
        ],
      });
    });
  }, []);

  // Dados do gráfico de barras
  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },
  };

  return (
    <>
      <Chart
        options={{ ...options, xaxis: chartData.labels }}
        series={chartData.series}
        type="bar"
        height="240"
      />
    </>
  );
};

export default BarChart;
