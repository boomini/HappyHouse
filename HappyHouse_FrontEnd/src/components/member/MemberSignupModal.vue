<template>
  <transition name="fade">
    <div v-if="modal" class="fixed inset-0 z-30">
      <!-- background -->
      <div
        v-show="modal"
        @click="showModal()"
        class="bg-filter bg-black bg-opacity-50 fixed inset-0 w-full h-full z-20"
      ></div>
      <!--          -->
      <main class="flex flex-col items-center justify-center h-full w-full">
        <transition name="fade-up-down">
          <div v-show="modal" class="modal-wrapper flex items-center z-30">
            <div
              class="modal max-w-md mx-5 xl:max-w-xl lg:max-w-xl md:max-w-xl bg-secondary-light dark:bg-primary-dark max-h-screen shadow-lg flex-row rounded-xl relative"
            >
              <div
                class="modal-header flex justify-between gap-10 p-5 border-b border-ternary-light dark:border-ternary-dark"
              >
                <h5 class=" text-primary-dark dark:text-primary-light text-2xl">
                  &emsp;회원가입&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                </h5>
                <button
                  class="px-4 font-bold text-primary-dark dark:text-primary-light"
                  @click="showModal()"
                >
                  X
                </button>
              </div>
              <div class="modal-body p-5 w-full h-full">
                <div class="max-w-xl m-4 text-left">
                  <div
                    show
                    v-if="pwMatches == false"
                    class="mt-6 bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative"
                    role="alert"
                  >
                    <strong class="font-bold">회원가입 실패! </strong>
                    <span class="block sm:inline"
                      >비밀번호를 확인해 주세요.</span
                    >
                  </div>
                  <div class="mt-6">
                    <label for="id"></label>
                    <input
                      class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-lg text-md dark:font-medium bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
                      id="id"
                      name="id"
                      type="text"
                      v-model="member.iduser"
                      required=""
                      placeholder="아이디를 입력해 주세요."
                      aria-label="Id"
                    />
                  </div>
                  <div
                    show
                    v-if="isSignupError == true"
                    class="mt-6 bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative"
                    role="alert"
                  >
                    <strong class="font-bold">아이디 중복! </strong>
                    <span class="block sm:inline"
                      >이미 사용중인 아이디입니다.</span
                    >
                  </div>
                  <div class="mt-6">
                    <label for="name"></label>
                    <input
                      class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-lg text-md dark:font-medium bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
                      id="name"
                      name="name"
                      type="text"
                      v-model="member.name"
                      required=""
                      placeholder="이름을 입력해 주세요."
                      aria-label="Name"
                    />
                  </div>
                  <div class="mt-6">
                    <label for="pw"></label>
                    <input
                      class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-lg text-md dark:font-medium bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
                      id="pw"
                      name="pw"
                      type="password"
                      v-model="member.password"
                      required=""
                      placeholder="비밀번호를 입력해 주세요."
                      aria-label="Pw"
                    />
                  </div>
                  <div class="mt-6">
                    <label for="pw2"></label>
                    <input
                      class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-lg text-md dark:font-medium bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
                      id="pw2"
                      name="pw2"
                      type="password"
                      v-model="password2"
                      required=""
                      placeholder="비밀번호를 똑같이 입력해 주세요."
                      aria-label="Pw2"
                    />
                  </div>
                  <div class="mt-6 inline-flex w-full">
                    <label for="email"></label>
                    <input
                      class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-lg text-md dark:font-medium bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
                      id="email"
                      name="email"
                      type="email"
                      v-model="email"
                      required=""
                      placeholder="이메일을 입력해 주세요."
                      aria-label="Email"
                    />
                    <div class="w-1/6 ml-2">
                      <button
                        class="bg-white hover:bg-gray-100 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow"
                        @click="sendMail"
                      >
                        인증
                      </button>
                    </div>
                  </div>
                  <div class="mt-6 inline-flex w-full">
                    <label for="email"></label>
                    <input
                      class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-lg text-md dark:font-medium bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
                      id="code"
                      name="code"
                      type="text"
                      v-model="code"
                      required=""
                      placeholder="메일로 전송된 인증번호를 입력해 주세요."
                      aria-label="Code"
                    />
                    <div class="w-1/6 ml-2">
                      <button
                        class="bg-white hover:bg-gray-100 text-gray-800 font-semibold py-2 px-4 border border-gray-400 rounded shadow"
                        @click="checkAuth"
                      >
                        확인
                      </button>
                    </div>
                  </div>
                  <div class="mt-6">
                    <label for="pw2"></label>
                    <input
                      class="w-full px-5 py-2 border-1 border-gray-200 dark:border-secondary-dark rounded-lg text-md dark:font-medium bg-secondary-light dark:bg-ternary-dark text-primary-dark dark:text-ternary-light"
                      id="address"
                      name="address"
                      type="text"
                      v-model="member.addr"
                      required=""
                      placeholder="주소를 입력해 주세요."
                      aria-label="address"
                    />
                  </div>

                  <div class="mt-6 pb-4 sm:pb-1">
                    <button
                      class="px-4
											sm:px-6
											py-2
											sm:py-2.5
											text-white
											font-normal
											sm:font-medium
											bg-indigo-500
											hover:bg-indigo-600
											rounded-md
											sm:rounded-lg
											focus:ring-1 focus:ring-indigo-900"
                      aria-label="Submit Request"
                      @click="register"
                    >
                      회원가입
                    </button>
                  </div>
                </div>
              </div>
              <div
                class="modal-footer mt-2 sm:mt-0 py-5 px-8 border0-t text-right"
              >
                <button
                  class=" px-4
									sm:px-6
									py-2
									bg-indigo-400
									hover:bg-indigo-500
									rounded-md
									sm:rounded-lg
									font-normal
									sm:font-bold
									text-primary-light
									focus:ring-1 focus:ring-indigo-900"
                  @click="showModal()"
                  aria-label="Close Modal"
                >
                  Close
                </button>
              </div>
            </div>
          </div>
        </transition>
      </main>
    </div>
  </transition>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import { emailConfirm, verifyCode } from "@/api/email.js";

const memberStore = "memberStore";

export default {
  name: "MemberSignupModal",
  props: ["showModal", "modal", "categories"],
  data() {
    return {
      member: {
        iduser: null,
        password: null,
        name: null,
        addr: null,
      },
      password2: null,
      pwMatches: true,
      email: "",
      code: "",
      emailSent: false,
      verified: false,
    };
  },
  created() {
    this.member.iduser = "";
    this.member.password = "";
    this.member.name = "";
    this.member.addr = "";
    this.password2 = "";
    this.SET_IS_SIGNUP_ERROR(false);
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "isSignupError"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_SIGNUP_ERROR"]),
    ...mapActions(memberStore, ["registerMember"]),

    pwCheck() {
      if (this.member.password == this.password2) {
        this.pwMatches = true;
      } else {
        this.pwMatches = false;
      }
    },
    async register() {
      console.log("회원가입 버튼 눌렸음");
      this.pwCheck();
      if (this.pwMatches && this.verified) {
        await this.registerMember(this.member);
        if (this.isSignupError == false) {
          alert("가입을 환영합니다!");
          this.showModal();
        }
      }
    },

    async sendMail() {
      await emailConfirm(this.email);
      alert(this.email + "으로 인증번호가 전송되었습니다.");
      this.emailSent = true;
    },

    async checkAuth() {
      if (this.emailSent) {
        await verifyCode(this.code).then((value) => {
          console.log(value.data);
          if (value.data == 1) {
            alert("메일 인증이 완료되었습니다.");
            this.verified = true;
          } else {
            alert(this.code + "가 인증번호와 일치하지 않습니다.");
            this.verified = false;
          }
        });
      } else {
        alert("메일을 입력하여 인증번호를 받아주세요.");
      }

      //   if ((await verifyCode(this.code)) == 1) {
      //     alert("메일 인증이 완료되었습니다.");
      //     this.verified = true;
      //   } else {
      //     alert(this.code + "가 인증번호와 일치하지 않습니다.");
      //     this.verified = false;
      //   }
      // } else {
      //   alert("메일을 입력하여 인증번호를 받아주세요.");
      // }
    },
  },
};
</script>

<style scoped>
.modal-body {
  max-height: 500px;
}

.bg-gray-800-opacity {
  background-color: #2d374850;
}

@media screen and (max-width: 768px) {
  .modal-body {
    max-height: 400px;
  }
}

.fade-up-down-enter-active {
  transition: all 0.3s ease;
}

.fade-up-down-leave-active {
  transition: all 0.3s ease;
}

.fade-up-down-enter {
  transform: translateY(10%);
  opacity: 0;
}

.fade-up-down-leave-to {
  transform: translateY(10%);
  opacity: 0;
}

.fade-enter-active {
  -webkit-transition: opacity 2s;
  transition: opacity 0.3s;
}

.fade-leave-active {
  transition: opacity 0.3s;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>
