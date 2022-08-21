//package ru.netology.nmedia_pusher.activity
//
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.viewModels
//import androidx.navigation.fragment.findNavController
//import androidx.navigation.fragment.navArgs
//import ru.netology.nmedia.util.CountLikeShare
//import ru.netology.nmedia_pusher.R
//import ru.netology.nmedia_pusher.activity.NewPostFragment.Companion.textArg
//import ru.netology.nmedia_pusher.adapter.PostViewHolder
//import ru.netology.nmedia_pusher.databinding.FragmentPostBinding
//import ru.netology.nmedia_pusher.dto.Post
//import ru.netology.nmedia_pusher.viewmodel.PostViewModel
//
////// TODO: Rename parameter arguments, choose names that match
////// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
////private const val ARG_PARAM1 = "param1"
////private const val ARG_PARAM2 = "param2"
////
/////**
//// * A simple [Fragment] subclass.
//// * Use the [PostFragment.newInstance] factory method to
//// * create an instance of this fragment.
//// */
//class PostFragment : Fragment() {
//
//    private val viewModel: PostViewModel by viewModels(ownerProducer = ::requireParentFragment)
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//    //________________________________________________________________________________________//
//val binding = FragmentPostBinding.inflate(inflater, container, false)
//    val id = arguments?.textArg
//
//    viewModel.data.observe(viewLifecycleOwner) { posts ->
//        binding.cardPost
//            .apply {
//            posts.map { post ->
//                if (post.id.toInt() == id) {
//
//                    author.text = post.author
//                    published.text = post.published
//                    content.text = post.content
//                    like.text = CountLikeShare.roundingCount(post.likes)
//                    share.text = CountLikeShare.roundingCount(post.share)
//
//                    view.text = CountLikeShareView.counterDecimal(post.viewNum)
//
//                    like.isChecked = post.liked
//
//                    if (post.video == null) {
//                        binding.content.playVideoGroup.visibility = View.GONE
//                    } else {
//                        binding.content.playVideoGroup.visibility = View.VISIBLE
//                    }
//
//                    like.setOnClickListener { viewModel.likeById(post.id) }
//                    share.setOnClickListener { viewModel.shareById(post.id) }
//                    play.setOnClickListener {
//                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(post.video))
//                        startActivity(intent)
//                    }
//                    backgroundVideo.setOnClickListener {
//                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(post.video))
//                        startActivity(intent)
//                    }
//
//                    menu.setOnClickListener {
//                        PopupMenu(it.context, it).apply {
//                            inflate(R.menu.post_menu)
//
//                            setOnMenuItemClickListener { menuItem ->
//                                when (menuItem.itemId) {
//                                    R.id.remove -> {
//                                        viewModel.removeById(post.id)
////                                            findNavController().navigate(
////                                                R.id.action_postFragment_to_feedFragment
////                                            )
//                                        findNavController().navigateUp()
//                                        true
//                                    }
//                                    R.id.edit -> {
//                                        viewModel.edit(post)
//                                        findNavController().navigate(
//                                            R.id.action_postFragment_to_newPostFragment,
//                                            Bundle().apply {
//                                                textArg = post.content
//                                            }
//                                        )
//                                        true
//                                    }
//                                    else -> false
//                                }
//                            }
//                        }.show()
//                    }
//                }
//            }
//        }
//    }
//    return binding.root
//}
//}
//
//    //________________________________________________________________________________________//
//
//
//
//
//
//
//
//
//
//
////
////
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        arguments?.let {
////            param1 = it.getString(ARG_PARAM1)
////            param2 = it.getString(ARG_PARAM2)
////        }
////    }
////
////    override fun onCreateView(
////        inflater: LayoutInflater, container: ViewGroup?,
////        savedInstanceState: Bundle?
////    ): View {
////
////        val binding = FragmentPostBinding.inflate(inflater, container, false)
////
////        val viewHolder = PostViewHolder(binding.cardPost, object : PostEventListener {
////
////            override fun onEdit(post: Post) {
////                viewModel.edit(post)
////                findNavController().navigate(
////                    R.id.action_postFragment_to_newPostFragment,
////                    Bundle().apply {
////                        textArg = post.content
////                    }
////                )
//////
////            }
////
////            override fun onRemove(post: Post) {
////                viewModel.removeById(post.id)
////            }
////
////            override fun onLike(post: Post) {
////                viewModel.likeById(post.id)
////            }
////
////            override fun onShare(post: Post) {
////                val intent = Intent().apply {
////                    action = Intent.ACTION_SEND
////                    putExtra(Intent.EXTRA_TEXT, post.content)
////                    type = "text/plain"
////                }
////                val shareIntent = Intent.createChooser(intent, "Share post")
////                startActivity(shareIntent)
////                viewModel.shareById(post.id)
////            }
////
////            override fun onVideo(post: Post) {
////                val intentVideo = Intent(Intent.ACTION_VIEW, Uri.parse(post.video))
////                startActivity(intentVideo)
////            }
////
////            override fun onPost(post: Post) {
////
////            }
////
////        })
////        //подписываемся на обновление списка
////        viewModel.data.observe(viewLifecycleOwner){posts->
////            //ищем пост, который нужно отобразить
////
////            val post = posts.find { it.id == args.postId.toLong()}?:run {
////                findNavController().navigateUp()
////                return@observe
////            }
////            viewHolder.bind(post)
////        }
////
////
////
////        return binding.root
////    }
////
////    companion object {
////        /**
////         * Use this factory method to create a new instance of
////         * this fragment using the provided parameters.
////         *
////         * @param param1 Parameter 1.
////         * @param param2 Parameter 2.
////         * @return A new instance of fragment PostFragment.
////         */
////        // TODO: Rename and change types and number of parameters
////        @JvmStatic
////        fun newInstance(param1: String, param2: String) =
////            //метод newInstanсе нужен, что бы сохранить логику создания нового объекта
////            //вернет класс PostFragment
////            PostFragment().apply {
////                arguments = Bundle().apply {
////                    //у которого в свойсвах аргумента записано две строчки
////                    putString(ARG_PARAM1, param1)
////                    putString(ARG_PARAM2, param2)
////                    //плучается, что мы вне класса PostFragment не вызваем конструктор
////                }
////            }
////    }
////}