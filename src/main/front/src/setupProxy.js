import { createProxyMiddleware } from "http-proxy-middleware";

module.exports = function (app) {
  app.use(
    createProxyMiddleware("/api",{
      target: "http://localhost:8080",
      changeOrigin: true,
    })
  );
};
