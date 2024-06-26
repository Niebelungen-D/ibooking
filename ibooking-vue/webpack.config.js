var path = require("path");
var webpack = require("webpack");

module.exports = {
  // publicPath: './',
  entry: "./src/main.js",
  output: {
    path: path.resolve(__dirname, "./dist"),
    publicPath: "/dist/",
    filename: "build.js",
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: "vue-loader",
        options: {
          // vue-loader options go here
        },
      },
      {
        test: /\.js$/,
        loader: "babel-loader",
        exclude: /node_modules/,
      },
      {
        test: /\.(png|jpg|gif|svg)$/,
        loader: "file",
        options: {
          name: "[name].[ext]?[hash]",
        },
      },
      {
        test: /\.css$/,
        loader: "style-loader!css-loader",
      },
      {
        test: /\.(eot|svg|ttf|woff|woff2)(\?\S*)?$/,
        loader: "file-loader",
      },
      {
        test: /\.(png|jpe?g|gif|svg)(\?\S*)?$/,
        loader: "file-loader",
        query: {
          name: "[name].[ext]?[hash]",
        },
      },
    ],
  },
  resolve: {
    alias: {
      vue$: "vue/dist/vue",
    },
  },
  devServer: {
    historyApiFallback: true,
    noInfo: true,
  },
  devtool: "#eval-source-map",
};

if (process.env.NODE_ENV === "production") {
  module.exports.devtool = "#source-map";
  // http://vue-loader.vuejs.org/en/workflow/production.html
  module.exports.plugins = (module.exports.plugins || []).concat([
    new webpack.DefinePlugin({
      "process.env": {
        NODE_ENV: '"production"',
      },
    }),
    new webpack.optimize.UglifyJsPlugin({
      compress: {
        warnings: false,
      },
    }),
    new webpack.LoaderOptionsPlugin({
      minimize: true,
    }),
  ]);
}
