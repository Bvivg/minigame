import axios, { type AxiosInstance, type AxiosRequestConfig } from "axios";

export default class Request {
  private static API: AxiosInstance = axios.create({
    baseURL: "/api",
    withCredentials: true,
  });

  private baseUrl: string;

  constructor(baseUrl: string) {
    this.baseUrl = baseUrl;
  }

  // === Static methods ===

  private static async request<T, R>(
    method: "get" | "post" | "patch" | "delete",
    url: string,
    data?: R,
    config?: AxiosRequestConfig
  ): Promise<T> {
    try {
      const body: AxiosRequestConfig = {
        method,
        url,
        data,
        ...config,
      };
      const response = await Request.API.request(body);
      return response.data;
    } catch (error: unknown) {
      if (error instanceof Error) {
        throw new Error(error.message);
      } else {
        throw new Error("Unknown error occurred");
      }
    }
  }

  static async get<T>(
    url: string,
    config: AxiosRequestConfig = {}
  ): Promise<T> {
    return await Request.request("get", url, null, config);
  }

  static async post<T, R>(
    url: string,
    data: R,
    config: AxiosRequestConfig = {}
  ): Promise<T> {
    return await Request.request("post", url, data, config);
  }

  static async patch<T, R>(
    url: string,
    data: R,
    config: AxiosRequestConfig = {}
  ): Promise<T> {
    return await Request.request("patch", url, data, config);
  }

  static async delete<T>(
    url: string,
    config: AxiosRequestConfig = {}
  ): Promise<T> {
    return await Request.request("delete", url, null, config);
  }

  // === Instance methods ===

  async get<T>(
    subUrl: string = "",
    config: AxiosRequestConfig = {}
  ): Promise<T> {
    return await Request.get<T>(this.buildUrl(subUrl), config);
  }

  async post<T, R>(
    data: R,
    subUrl: string = "",
    config: AxiosRequestConfig = {}
  ): Promise<T> {
    return await Request.post<T, R>(this.buildUrl(subUrl), data, config);
  }

  async patch<T, R>(
    data: R,
    subUrl: string = "",
    config: AxiosRequestConfig = {}
  ): Promise<T> {
    return await Request.patch<T, R>(this.buildUrl(subUrl), data, config);
  }

  async delete<T>(
    subUrl: string = "",
    config: AxiosRequestConfig = {}
  ): Promise<T> {
    return await Request.delete<T>(this.buildUrl(subUrl), config);
  }

  private buildUrl(subUrl?: string): string {
    return subUrl ? `${this.baseUrl}/${subUrl}` : this.baseUrl;
  }
}
