import type IEntity from "./entity";

export default interface IUserEntity extends IEntity {
  username: string;
  password: string;
  avatar: string;
}
